import React, { Component } from 'react';
import {Nav,Navbar,NavItem,NavbarBrand, NavLink} from 'reactstrap';


export default class AppNav extends Component {
    state = {  }
    render() {
        return (
          <div>
            <Navbar color="dark" dark  expand="md">
              <NavbarBrand href="/">Community Outreach Intake Form</NavbarBrand>
                <Nav className="ml-auto" navbar>
                <NavItem>
                    <NavLink href="/">Home</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/">Add/Edit Client</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/categories">Add/View Case Manager</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/expenses">View Resources</NavLink>
                  </NavItem>
                
                </Nav>
          
            </Navbar>
          </div>
        );
      }
}
 
