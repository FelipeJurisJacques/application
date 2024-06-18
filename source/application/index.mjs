WebAssembly.instantiateStreaming(fetch(new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)), wasmImports).then(result => {
    for (let i in result.instance.exports) {
        if (i !== 'main') {
            wasmImports.native[i] = result.instance.exports[i]
        }
    }
    result.instance.exports.main()
}).catch(error => {
    console.error(error)
})