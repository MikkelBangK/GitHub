using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace Session2Eksempel
{
    internal class Person
    {
        private static readonly String[] muligeTitler = { "Udvikler", "Projektleder" };
        private List<String> titler = new List<String>();
        private string navn = "";

        public Person(Alder minAlder, string navn)
        {
            MinAlder = minAlder;
            Navn = navn;
        }

        public Alder MinAlder { get; set; }
        public String Navn { 
            get { 
                return navn; 
            } 
            set { 
                navn = value; 
            } 
        }

        public void tilfoejTitel(String titel)
        {
            if (!muligeTitler.Contains(titel))
            {
                throw new ArgumentException("Ugyldig titel", "titel");
            }
            titler.Add(titel);
        }
    }
}
