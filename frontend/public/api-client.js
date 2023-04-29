(async () => {
    let url = 'https://megaserver/api/now'
    let response = await window.fetch(url, {})
    let body = await response.json()
    console.log(body)

    document.getElementById("payload").textContent = body
})();