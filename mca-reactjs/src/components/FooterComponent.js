import * as React from "react";

class FooterComponent extends React.Component {
    render() {
        return (
          <div class="footer fixed-bottom bg-dark text-light text-center">
            <span>&copy; 2022 Java Developer | <a href="https://github.com/gusrylmubarok/multiplication-comp-app" className="link-light text-decoration-none">Github</a></span>

          </div>
        );
    }
}

export default FooterComponent;
