
using System.Diagnostics;
using DataAccess.Model;
using Microsoft.EntityFrameworkCore;

namespace DataAccess.Context;
internal class StuderendeContext : DbContext
{
    public StuderendeContext()
    {
        bool created = Database.EnsureCreated();
        if (created)
        {
            Debug.WriteLine("Database created");
        }
    }
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Server=localhost,1433;Database=StuderendeC#;User Id=sa;Password=reallyStrongPwd123;TrustServerCertificate=true");
        optionsBuilder.LogTo(message => Debug.WriteLine(message));
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Studerende>().HasData(new Studerende[]
        {
            new Studerende("Nikolaj", 27, DateTime.Now, Studietype.bachelor),
            new Studerende("Mikkel", 30, DateTime.Now, Studietype.bachelor),
            new Studerende("Emil", 32, DateTime.Now, Studietype.kandidat)
        });
    }
    public DbSet<Studerende> Studerende { get; set; }
}