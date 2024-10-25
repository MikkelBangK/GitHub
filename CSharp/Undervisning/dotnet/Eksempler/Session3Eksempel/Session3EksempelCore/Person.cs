using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace Session3Eksempel
{
    internal class Person : IHarAlder
    {
        private static readonly String[] muligeTitler = { "Udvikler", "Projektleder" };
        private List<String> titler = new List<String>();

        public Person(int alder)
        {
            this.Alder = alder;
        }
        public int Alder { get; set; }

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
