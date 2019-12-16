class Clock extends React.Component {
  constructor(props) {
    super(props);
    this.state = {date: new Date()};
  }
  
  componentDidMount() { //запускает таймер
    this.timerID = setInterval(
      () => this.tick(),
      1000
    );
  }

  componentWillUnmount() {
clearInterval(this.timerID); //очищает
  }

  tick() { // этот метод устанавливает состоянию новую дату
    this.setState({
      date: new Date()
    });
  }
  
  render() {
    return (
      <div>
        <h5 align = 'center' > {this.state.date.toLocaleTimeString()}.</h5>
      </div>
    );
  }
}

ReactDOM.render(
  <Clock />,
  document.getElementById('clock')
);
