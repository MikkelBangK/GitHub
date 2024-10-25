using ExtensionMethods;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KoeretoejExtensionMethods
{
    internal static class Exts
    {
        public static String GetInfo(this Koeretoej x, bool english)
        {
            if (english)
            {
                return "Vehicle:" + x.Name;
            } else
            {
                return "Køretøj:" + x.Name;
            }
        }










        public static String GetInfo(this Bil x, bool english)
        {
            if (english)
            {
                return "Car:" + x.Name;
            }
            else
            {
                return "Bil:" + x.Name;
            }
        }

    }
}
