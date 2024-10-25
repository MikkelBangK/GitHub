namespace Opgave2;

public partial class MainPage
{
    private void Ombyt1_OnClicked(object sender, EventArgs e)
    {
        var temp1 = new Label();
        var temp2 = new Label();
        temp1.Text = Slikolaj.Text;
        temp2.Text = Emil.Text;
        Slikolaj.Text = temp2.Text;
        Emil.Text = temp1.Text;
    }

    private void Ombyt2_OnClicked(object sender, EventArgs e)
    {
        var temp3 = new Label();
        var temp4 = new Label();
        temp3.Text = Banjomin.Text;
        temp4.Text = Mikkel.Text;
        Banjomin.Text = temp4.Text;
        Mikkel.Text = temp3.Text;
    }
}