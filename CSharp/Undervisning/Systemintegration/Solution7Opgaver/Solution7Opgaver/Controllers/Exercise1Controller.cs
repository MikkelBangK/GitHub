using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Newtonsoft.Json;

namespace Solution7Opgaver.Controllers
{
    public class Exercise1Controller : Controller
    {
        private List<SelectListItem> countryList = new List<SelectListItem>();
        private static string Key = "countryList";
        
        [HttpGet]
        public IActionResult Index()
        {
            if (HttpContext.Session.GetString(Key) == null){
                countryList.Add(new SelectListItem { Text = "China", Value = "CN"});
                countryList.Add(new SelectListItem { Text = "Denmark", Value = "DK"});
                countryList.Add(new SelectListItem { Text = "Japan", Value = "JP"});
                HttpContext.Session.SetString(Key, JsonConvert.SerializeObject(countryList));

            }
            else
            {
                countryList =
                    JsonConvert.DeserializeObject<List<SelectListItem>>(HttpContext.Session.GetString(Key));

            }
            ViewBag.Countries = countryList;
            return View();
        }
        
        [HttpPost]
        public IActionResult Index(string Countries)
        {
            ViewBag.Countries =
                JsonConvert.DeserializeObject<List<SelectListItem>>(HttpContext.Session.GetString(Key));
            ViewBag.CC = Countries;
            return View();
        }
        
        [HttpPost]
        public IActionResult AddCountry(IFormCollection formData)
        {
            if (HttpContext.Session.GetString(Key) != null)
            {
                countryList = JsonConvert.DeserializeObject<List<SelectListItem>>(HttpContext.Session.GetString(Key));
            }
            string country = formData["Country"];
            string countryCode = formData["CountryCode"];
            countryList.Add(new SelectListItem { Text = country, Value = countryCode});
            HttpContext.Session.SetString(Key, JsonConvert.SerializeObject(countryList));
            ViewBag.Countries = countryList;
            return View("Index");
        }
    }
}
