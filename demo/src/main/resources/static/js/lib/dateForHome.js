
const date = {
    showDate() {
        let d = new Date();
        let curr_date = d.getDate();
        let curr_month = d.getMonth() + 1; //months are zero based
        let curr_year = d.getFullYear();
        return (curr_date + "-" + curr_month + "-" + curr_year);
    },
    init() {
        let divDate = document.getElementById("divForDate");
        let pDate = divDate.children.item(0);
        pDate.textContent = this.showDate();
    }
}

window.addEventListener('load', () => date.init())