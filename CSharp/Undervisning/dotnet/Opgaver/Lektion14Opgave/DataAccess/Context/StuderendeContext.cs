
using Microsoft.EntityFrameworkCore;

namespace DataAccess.Context;
using System.Diagnostics;
internal class StuderendeContext : DbContext
{
    public StuderendeContext()
    {
        bool created = Database.EnsureCreated();
        if (created)
        {
            Debug.WriteLine("Database created");
        }
    }
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Data Source=EAA-SH-KLBO-KU\\SQLEXPRESS;Initial Catalog=Studerende;Integrated Security = SSPI; TrustServerCertificate=true");
        optionsBuilder.LogTo(message => Debug.WriteLine(message));
    }
}