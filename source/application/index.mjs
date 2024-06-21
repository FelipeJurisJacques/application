WebAssembly.instantiateStreaming(fetch(new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)), wasmImports).then(result => {
    for (let i in result.instance.exports) {
        if (i !== 'main') {
            wasmImports.native[i] = result.instance.exports[i]
        }
    }
    wasmImports.native.promise = promise => {
        promise.then(value => {
            result.instance.exports.promiseResolve(promise, value)
        })
        promise.catch(error => {
            result.instance.exports.promiseReject(promise, error)
        })
    }
    result.instance.exports.main()
}).catch(error => {
    console.error(error)
})