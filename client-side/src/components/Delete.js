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
            id: this.props.eachCost.id,
            month: this.props.eachCost.month,
            year: this.props.eachCost.year
        })
    }
    componentWillReceiveProps(nextProps){
        this.setState({
            id: nextProps.eachCost.id,
            month:nextProps.eachCost.month,
            year:nextProps.eachCost.year
        })
    }
    onClick(e){
        this.delete(this);
    }
    delete(e){
        axios.delete('http://localhost:8080/financialtransaction',{
            params: { id: e.state.id }
        })
            .then((res) => {
            });
    }
    render(){
        return (
            <Button bsStyle="danger" bsSize="small" onClick={this.onClick}>
                <Link to={{pathname: '/', search: '?month='+this.state.month+'&year='+this.state.year}} style={{ textDecoration: 'none' }}>
                    <span className="glyphicon glyphicon-remove" />
                </Link>
            </Button>
        )
    }
}
export default Delete;