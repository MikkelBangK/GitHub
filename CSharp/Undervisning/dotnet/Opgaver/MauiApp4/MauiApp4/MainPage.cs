namespace MauiApp4;

public partial class MainPage
{
    private void HideButton(object sender, CheckedChangedEventArgs e)
    {
        CounterBtn.IsVisible = e.Value;
    }
}