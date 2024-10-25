using Microsoft.AspNetCore.Mvc;

namespace Lektion6.Controllers
{
    public class CalculatorController : Controller
    {
        // GET: CalculatorController
        public IActionResult Index()
        {
            return RedirectToAction("TimeCalculator");
        }
        [HttpGet]
        public ActionResult TimeCalculator()
        {
            return View();
        }
        [HttpPost]
        public ActionResult TimeCalculator(IFormCollection formCollection)
        {
            int hours = string.IsNullOrEmpty(formCollection["Hours"]) ? 0 : Convert.ToInt32(formCollection["Hours"]);
            int minutes = string.IsNullOrEmpty(formCollection["Minutes"]) ? 0 : Convert.ToInt32(formCollection["Minutes"]);
            int seconds = string.IsNullOrEmpty(formCollection["Seconds"]) ? 0 : Convert.ToInt32(formCollection["Seconds"]);
            int totalSeconds = hours * 3600 + minutes * 60 + seconds;
            ViewBag.TotalSeconds = totalSeconds;
            return View();
        }
    }
}
