using Microsoft.AspNetCore.Mvc;

namespace Lektion6.Controllers
{
    public class SimpleCalculatorController : Controller
    {
        // GET: SimpleCalculator
        public IActionResult Index()
        {
            return RedirectToAction("SimpleCalculator");
        }
        [HttpGet]
        public ActionResult SimpleCalculator()
        {
            return View();
        }
        
        [HttpPost]
        public ActionResult SimpleCalculator(IFormCollection formCollection)
        {
            int first = Convert.ToInt32(formCollection["First"]);
            int second = Convert.ToInt32(formCollection["Second"]);
            string operation = formCollection["operation"];
            int result = 0;
            switch (operation)
            {
                case "Add":
                    result = first + second;
                    break;
                case "Subtract":
                    result = first - second;
                    break;
                case "Multiply":
                    result = first * second;
                    break;
                case "Divide":
                    result = first / second;
                    break;
            }
            ViewBag.Result = result;
            return View();
        }

    }
}
