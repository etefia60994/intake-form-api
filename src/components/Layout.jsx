
import React from 'react'
import { NavBar } from './reactstrap'

export default ({ children }) => (
  <>
    <NavBar color={'secondary'} />
    {children}
  </>
)