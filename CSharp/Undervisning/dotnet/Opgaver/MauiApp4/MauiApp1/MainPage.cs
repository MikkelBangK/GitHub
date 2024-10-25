namespace MauiApp1;

public partial class MainPage
{
    private void North_OnClicked(object sender, EventArgs e)
    {
        Editor.Text += North.Text + "\n";
    }

    private void East_OnClicked(object sender, EventArgs e)
    {
        Editor.Text += East.Text + "\n";
    }

    private void West_OnClicked(object sender, EventArgs e)
    {
        Editor.Text += West.Text + "\n";
    }

    private void South_OnClicked(object sender, EventArgs e)
    {
        Editor.Text += South.Text + "\n";
    }
}