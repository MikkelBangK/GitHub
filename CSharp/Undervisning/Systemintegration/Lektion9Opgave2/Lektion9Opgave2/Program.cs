

using System.Net.Mime;
using System.Text;
using Newtonsoft.Json;
using OfficeOpenXml;
using RabbitMQ.Client;

static class Program
{
    public static void Main(string[] args)
    { 
        ExcelPackage.LicenseContext = LicenseContext.NonCommercial;
        var fileInfo = new FileInfo("test.xlsx");
        ExcelPackage package;
    //Tjekker om den filen allerede er lavet
    if (fileInfo.Exists)
    {
        package = new ExcelPackage(fileInfo);
        Console.WriteLine("Existing Excel file opened.");
    }
    else
    {
        package = new ExcelPackage();
        Console.WriteLine("New Excel file created with headers.");
    }
    ExcelWorksheet worksheet = package.Workbook.Worksheets["FlightInfo"];

    if (worksheet == null)
    {
        worksheet = package.Workbook.Worksheets.Add("FlightInfo");
        worksheet.Cells[1, 1].Value = "Flightnumber";
        worksheet.Cells[1, 2].Value = "ETA";
        Console.WriteLine("New 'FlightInfo' sheet created with headers.");
    }
    var nextRow = worksheet.Dimension?.Rows + 1 ?? 2;
    worksheet.Cells[nextRow, 1].Value = "SAS1234";
    worksheet.Cells[nextRow, 2].Value = DateTime.UtcNow.AddHours(2).ToString("yyyy-MM-ddTHH:mm:ssZ");  // ETA


    package.SaveAs(fileInfo);
    package.Dispose();

    Console.WriteLine($"Excel file saved with new flight data in row {nextRow}!");
    
    var factory = new ConnectionFactory() { HostName = "localhost" };
    using (var connection = factory.CreateConnection())
    using (var channel = connection.CreateModel())
    {
        var message = new
        {
            Header = new
            {
                MessageType = "FlightInfo",
                Timestamp = DateTime.UtcNow.ToString("yyyy-MM-ddTHH:mm:ss")
            },
            Body = new
            {
                Airline = "SAS",
                FlightNo = "SAS1234",
                ScheduledTime = DateTime.UtcNow.AddHours(2).ToString("yyyy-MM-ddTHH:mm:ss"),
                Destination = "CPH",
                CheckIn = "B12"
            }
        };
        var messageBody = JsonConvert.SerializeObject(message);
        var body = Encoding.UTF8.GetBytes(messageBody);
        
        channel.BasicPublish(exchange: "",
            routingKey: "SASQueue",
            basicProperties: null,
            body: body);
        Console.WriteLine("Message sent to queue.");
    }
    
    
}
}