const origin = new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)
Object.prototype.asciiToString = function () {
    const list = []
    for (let ascii of this[2]) {
        list.push(String.fromCharCode(ascii))
    }
    return list.join('')
}
WebAssembly.instantiateStreaming(fetch(origin), wasmImports).then(result => {
    result.instance.exports.main()
}).catch(error => {
    console.error(error)
})