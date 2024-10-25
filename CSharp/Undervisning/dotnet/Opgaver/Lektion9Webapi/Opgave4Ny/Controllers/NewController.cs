using Lektion9Webapi;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace Opgave4Ny.Controllers
{
    public class NewController : Controller
    {
        private readonly HttpClient _httpClient;

        public NewController(HttpClient httpClient)
        {
            _httpClient = httpClient;
            _httpClient.BaseAddress = new Uri("http://localhost:5120/api/values");
        }

        // GET: NewController
        public async Task<ActionResult> Index()
        {
            var response = await _httpClient.GetAsync("values");
            if (response.IsSuccessStatusCode)
            {
                var responseString = await response.Content.ReadAsStringAsync();
                var persons = JsonConvert.DeserializeObject<List<Person>>(responseString);
                return View(persons);
            }

            return View(new List<Person>());
        }

        public async Task<IActionResult> PersonInfo(int id)
        {
            var response = await _httpClient.GetAsync($"values/{id}");
            if (response.IsSuccessStatusCode)
            {
                var responseString = await response.Content.ReadAsStringAsync();
                var person = JsonConvert.DeserializeObject<Person>(responseString);
                return View(person);
            }

            return NotFound();
        }
        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Create(Person person)
        {
            var response = await _httpClient.PostAsJsonAsync("api/values/AddPerson", person);
            if (response.IsSuccessStatusCode)
            {
                return RedirectToAction(nameof(Index));
            }

            return View(person);
        }
        
        

}
}
