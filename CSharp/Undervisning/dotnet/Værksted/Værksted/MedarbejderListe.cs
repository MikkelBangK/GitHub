using System.Collections;
using System.Collections.Generic;
namespace Værksted;
using System;
public class MedarbejderListe<TKey >
{
    private readonly Dictionary<TKey, Medarbejder > _collection = new Dictionary<TKey,
        Medarbejder >();

    void AddElement(TKey k, Medarbejder p)
    {
        if (!_collection.ContainsKey(k))
        {
            _collection.Add(k, p);
        }
    }

    Medarbejder GetElement(TKey k)
    {
        if (_collection.TryGetValue(k, out var p))
        {
            return p;
        }
        else
        {
            return null;
        }
    }

    int Size()
    {
        return _collection.Count;
    }
}