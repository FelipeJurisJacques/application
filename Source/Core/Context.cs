using Microsoft.JSInterop;

namespace Application.Source.Core
{
    public class Context(IJSRuntime js)
    {
        private readonly IJSRuntime _js = js;
        private readonly Display _display = new(js);

        public Display GetDisplay()
        {
            return _display;
        }
    }
}