import * as React from "react";

class HeaderComponent extends React.Component {
    render() {
        return (
              <div className="navbar navbar-dark bg-dark">
                <div className="container-fluid">
                  <div className="navbar-brand fw-bolder">MCA</div>
                </div>
              </div>
        );
    }
}

export default HeaderComponent;
