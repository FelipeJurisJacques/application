const origin = new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)
WebAssembly.instantiateStreaming(fetch(origin), wasmImports).then(results => {
    console.log(
        results.instance.exports,
        results.instance.exports.main()
    )
}).catch(error => {
    console.error(error)
})
