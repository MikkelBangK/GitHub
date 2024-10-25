using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Lektion9Webapi.Properties
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        public static List<Person> Persons { get; set; } = new List<Person>()
        {
            new Person("Slikolaj", 28, 1), 
            new Person("Banjomin", 26, 2)
        };
        
        [HttpGet("GetPersoner")]
        public List<Person> GetPersoner()
        {
 
            return Persons;
        }
        
        [HttpGet("GetPerson")]
        public Person GetPerson(int id)
        {
            return Persons.FirstOrDefault(p => p.Id == id);
            
        }
        
        [HttpPost("AddPerson")]
        public void AddPerson(Person p)
        {
            Persons.Add(p);
        }
    }
}
