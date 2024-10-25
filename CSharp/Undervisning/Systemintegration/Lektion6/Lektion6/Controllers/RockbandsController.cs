using Microsoft.AspNetCore.Mvc;

namespace Lektion6.Controllers
{
    public class RockbandsController : Controller
    {
        // GET: RockbandsController
        public ActionResult Index()
        {
            string[] bands = new string[]
            {
                "Avenged Sevenfold", "Slipknot", "Asking Alexandria", "BFVM", "Throw The Fight", "I Prevail",
                "Falling in Reverse", "Motionless in White", "Bad Omens", "Ice Nine Kills"
            };
            ViewBag.Bands = bands;
            
            return View();
        }

    }
}
