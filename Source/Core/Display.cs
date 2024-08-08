using Microsoft.JSInterop;
using Application.Source.Utils.Observer;

namespace Application.Source.Core
{
    public class Display
    {

        private readonly IJSRuntime _js;
        private readonly OnResizeSubject _onResize;

        public Display(IJSRuntime jsRuntime)
        {
            _js = jsRuntime;
            _onResize = new OnResizeSubject();
        }

        public async Task<int> GetWidth()
        {
            return await _js.InvokeAsync<int>("eval", "window.innerWidth");
        }

        public async Task<int> GetHeight()
        {
            return await _js.InvokeAsync<int>("eval", "window.innerHeight");
        }

        public OnResizeSubject OnResize()
        {
            return _onResize;
        }

        public class OnResizeSubject : Subject { }
    }
}