using Microsoft.JSInterop;

namespace Application.Source.Core
{
    public class Display(IJSRuntime jsRuntime)
    {

        private readonly IJSRuntime _js = jsRuntime;

        public async Task<int> GetWidth()
        {
            return await _js.InvokeAsync<int>("eval", "window.innerWidth");
        }

        public async Task<int> GetHeight()
        {
            return await _js.InvokeAsync<int>("eval", "window.innerHeight");
        }
    }
}