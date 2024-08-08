using Microsoft.JSInterop;

namespace Application.Source.Core
{
    public class Context
    {
        private readonly IJSRuntime _js;
        private readonly Display _display;

        public Context(IJSRuntime js)
        {
            _js = js;
            _display = new(js);
            _js.InvokeVoidAsync(
                "eventsInterop.initialize",
                DotNetObjectReference.Create(this)
            );
        }

        public Display GetDisplay()
        {
            return _display;
        }

        [JSInvokable]
        public void OnEvent(string type)
        {
            _js.InvokeVoidAsync("console.log", type);
        }
    }
}