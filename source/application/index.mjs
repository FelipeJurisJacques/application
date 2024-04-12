WebAssembly.instantiateStreaming(fetch(new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)), wasmImports).then(result => {
    result.instance.exports.main()
}).catch(error => {
    console.error(error)
})