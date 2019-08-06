import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
class Delete extends React.Component {
constructor(){
  super();
  this.state={id: '', month: '', year: ''};
  this.onClick = this.onClick.bind(this);
  this.delete = this.delete.bind(this);
}
componentDidMount() {
    this.setState({
      id: this.props.financialTransaction.id,
      month: this.props.financialTransaction.month,
      year: this.props.financialTransaction.year
    })
  }
componentWillReceiveProps(nextProps){
  this.setState({
    id: nextProps.financialTransaction.id,
    month:nextProps.financialTransaction.month,
    year:nextProps.financialTransaction.year
  })
  }
onClick(e){
     this.delete(this);
    }
delete(e){
    axios.delete('http://localhost:8080/expense',{
        params: { id: e.state.id }
      })
      .then(function(response) {
});
}
render(){
  return (
    <Button bsStyle="danger" bsSize="small" onClick={this.onClick}>
     <Link to={{pathname: '/', search: '?month='+this.state.month+'&year='+this.state.year}} style={{ textDecoration: 'none' }}>
                  <span className="glyphicon glyphicon-remove"></span>
         </Link>
    </Button>
)
 }
}
export default Delete;
