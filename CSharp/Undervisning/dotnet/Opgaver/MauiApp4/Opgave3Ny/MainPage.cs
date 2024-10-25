namespace Opgave3Ny;

public partial class MainPage
{
    private void HideButton(object sender, CheckedChangedEventArgs e)
    {
        ClickMe.IsVisible = e.Value;
    }

    private void ButtonClicked(object sender, EventArgs e)
    {
        ClickMe.Text = "Clicked!";
    }
}