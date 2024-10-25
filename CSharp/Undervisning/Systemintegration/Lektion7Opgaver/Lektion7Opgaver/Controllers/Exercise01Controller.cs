using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;

namespace Lektion7Opgaver.Controllers
{
    public class Exercise01Controller : Controller
    {
        // GET: Exercise01Controller
        public IActionResult Index()
        {
            List<SelectListItem> countries = new List<SelectListItem>();
            countries.Add(new SelectListItem { Text = "Denmark", Value = "DK"});
            countries.Add(new SelectListItem { Text = "Germany", Value = "DE"});
            ViewBag.Countries = countries;
            return View();
        }

    }
}
