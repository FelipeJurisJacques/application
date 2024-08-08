window.eventsInterop = {
    initialize: function (dotNetObject) {
        window.addEventListener('resize', event => {
            dotNetObject.invokeMethodAsync('OnEvent', event.type)
        })
    }
}