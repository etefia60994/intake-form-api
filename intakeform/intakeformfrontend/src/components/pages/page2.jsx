import React, { Component } from 'react';
import { Navbar } from 'reactstrap';
class Resource extends Component {

    state = {  
        isLoading : true,
        Resources : []
    }
 
    async componentDidMount(){
        const response=await fetch('/api/ResourceCategories');
        const body = await response.json();
        this.setState({Resources : body , isLoading: false});
    }

    render() { 
        const {Resources , isLoading} = this.state;
        if(isLoading) 
            return (<div>Loading...</div>);
        
        return ( 
            
                <div>
                    <Navbar>
                    <h2>Resources</h2>
                    {
                        Resources.map( resource => 
                            <div id={resource.id}>
                                {resource.name}
                            </div>
                        )

                    }
</Navbar>
                </div>
         );
    }
}
 
export default Resource;