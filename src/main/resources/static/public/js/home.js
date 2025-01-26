// 날짜 포멧터
function formatDate(date) {
    const year = date.getFullYear();
    const month = ("0" + (date.getMonth() + 1)).slice(-2); // 0을 붙여서 2자리로 만들기
    const day = ("0" + date.getDate()).slice(-2); // 0을 붙여서 2자리로 만들기
    const hours = ("0" + date.getHours()).slice(-2); // 0을 붙여서 2자리로 만들기
    const minutes = ("0" + date.getMinutes()).slice(-2); // 0을 붙여서 2자리로 만들기

    // 원하는 포맷으로 반환
    return `${year}-${month}-${day} ${hours}:${minutes}`;
}