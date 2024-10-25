using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Session3Eksempel
{
    internal class Lastvogn:Koeretoej
    {
        private bool lang;

        public Lastvogn(string farve, double vaegt, Boolean lang) : base(farve, vaegt)
        {
            this.lang = lang;
        }

        public override int AntalHjul()
        {
            return lang ? 8 : 6;
        }
    }
}
