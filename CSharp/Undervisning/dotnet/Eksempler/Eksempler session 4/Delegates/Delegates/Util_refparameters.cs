using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegates_ref
{
    public delegate void Transformer(ref int x); //Make it generic
    internal class Util_refparameters
    {
        public static void Transform(int[] values, Transformer t)
        {
            for (int i = 0; i < values.Length; i++)
            {
                t.Invoke(ref values[i]);
            }
        }
    }
}
