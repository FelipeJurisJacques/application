WebAssembly.instantiateStreaming(fetch(new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)), wasmImports).then(result => {
    wasmImports.native.message = result.instance.exports.message
    result.instance.exports.main()
    console.log(result.instance.exports)
}).catch(error => {
    console.error(error)
})