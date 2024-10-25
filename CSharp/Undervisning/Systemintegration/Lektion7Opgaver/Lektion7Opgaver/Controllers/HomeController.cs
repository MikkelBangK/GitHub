using Microsoft.AspNetCore.Mvc;

namespace Lektion7Opgaver.Controllers
{
    public class HomeController : Controller
    {
        // GET: HomeController
        public IActionResult Index()
        {
            return View();
        }

    }
}
