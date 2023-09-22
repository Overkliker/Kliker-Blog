const settings = {
    rowsCount: 10,
    columnsCount: 10,
    startXPos: 0,
    startYPos: 8,
    startDirection: 'up',
    stepsInSec: 5,
    playerStepColor: "#aa3333",
    emptyCellColor: '#eeeeee'
};


const player = {
    x: null,
    y: null,
    direction: null,

    init(startXPos, startYPos, startDirection){
        this.x = startXPos
        this.y = startYPos
        this.direction = startDirection
    },

    makeStep(){
        const nextPoint = this.getNextPoint();
        this.x = nextPoint.x;
        this.y = nextPoint.y;
    },

    getNextPoint(){
        const point = {
            y: this.y,
            x: this.x
        }

        switch (this.direction) {
            case 'up':
                if (this.y > 0){
                    point.y--;
                }
                break;
            case 'down':
                if (this.y < 9){
                    point.y++;
                }
                break;
            case 'right':
                if (this.x < 9){
                    point.x++;
                }
                break;
            case 'left':
                if (this.x > 0){
                    point.x--;
                }
                break;
        }
        return point;
    }
};

const game = {
    player,
    settings,
    containerElement: null,
    cellsList: null,

    run() {
        this.init();

        this.render();
        setInterval(() =>{
            this.player.makeStep();
            this.render();
        }, 1000 / this.settings.stepsInSec)

    },
    init() {
        this.player.init(settings.startXPos, settings.startYPos, settings.startDirection);
        this.containerElement = document.getElementById('game');
        this.initCells();
        this.initEventHendlers();
    },
    initCells(){
        this.containerElement.innerHTML = '';
        this.cellsList = [];
        for (let row = 0; row < this.settings.rowsCount; row++){
            const newElem = document.createElement('tr');
            this.containerElement.appendChild(newElem)
            for (let col = 0; col < settings.columnsCount; col++){
                const cell = document.createElement('td');
                this.cellsList.push(cell);
                newElem.appendChild(cell);
            }
            this.cellsList.push(newElem)
        }
        console.log((this.cellsList));
    },
    initEventHendlers(){
        document.addEventListener('keydown', event => this.keyDownHandler(event))
    },

    keyDownHandler(event){
        switch (event.code){
            case 'KeyW':
                this.player.direction = 'up';
                break;
            case 'KeyS':
                this.player.direction = 'down';
                break;
            case 'KeyA':
                this.player.direction = 'left';
                break;
            case 'KeyD':
                this.player.direction = 'right';
                break;
        }
    },

    render(){
        this.cellsList.forEach(cell => cell.style.background = this.settings.emptyCellColor)

        const playerCell = document.querySelector(`tr:nth-child(${this.player.y + 1})`)
            .querySelector(`td:nth-child(${this.player.x + 1})`);

        playerCell.style.backgroundColor = this.settings.playerStepColor;

    }
};


window.addEventListener('load', () => game.run());
