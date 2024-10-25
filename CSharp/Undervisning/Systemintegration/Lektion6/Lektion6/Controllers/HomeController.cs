using Microsoft.AspNetCore.Mvc;
namespace Lektion6.Controllers
{
    public class HomeController : Controller
    {
        // GET: HomeController
        public ActionResult Index()
        {
            string name = "Slikolaj";
            int age = 28;
            DateTime birthdate = new DateTime(1996, 11, 10);
            ViewBag.Name = name;
            ViewBag.Age = age;
            ViewBag.Birthdate = birthdate.ToString("dd-MM-yyyy");
            return View();
        }

    }
}
