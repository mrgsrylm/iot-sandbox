import * as React from "react";
import ChallengesApiClient from "../services/ChallengesApiClient";
import LastAttemptsComponent from "./LastAttemptsComponent";
import LeaderBoardComponent from "./LeaderBoardComponent";

class ChallengeComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      a: "",
      b: "",
      user: "",
      message: "",
      guess: 0,
      lastAttempts: [],
    };
    this.handleSubmitResult = this.handleSubmitResult.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  componentDidMount(): void {
    this.refreshChallenge();
  }

  refreshChallenge() {
    ChallengesApiClient.challenge().then((res) => {
      if (res.ok) {
        res.json().then((json) => {
          this.setState({
            a: json.factorA,
            b: json.factorB,
          });
        });
      } else {
        this.updateMessage("Can't reach the server");
      }
    });
  }

  handleChange(event) {
    const name = event.target.name;
    this.setState({
      [name]: event.target.value,
    });
  }

  handleSubmitResult(event) {
    event.preventDefault();
    ChallengesApiClient.sendGuess(
      this.state.user,
      this.state.a,
      this.state.b,
      this.state.guess
    ).then((res) => {
      if (res.ok) {
        res.json().then((json) => {
          if (json.correct) {
            this.updateMessage("Congratulations! Your guess is correct");
          } else {
            this.updateMessage(
              "Oops! Your guess " +
                json.resultAttempt +
                " is wrong, but keep playing!"
            );
          }
          this.updateLastAttempts(this.state.user);
          this.refreshChallenge();
        });
      } else {
        this.updateMessage("Error: server error or not available");
      }
    });
  }

  updateMessage(m: string) {
    this.setState({
      message: m,
    });
  }

  updateLastAttempts(userAlias: string) {
    ChallengesApiClient.getAttempts(userAlias).then((res) => {
      if (res.ok) {
        let attempts: Attempt[] = [];
        res.json().then((data) => {
          data.forEach((item) => {
            attempts.push(item);
          });
          this.setState({
            lastAttempts: attempts,
          });
        });
      }
    });
  }

  render() {
    return (
      <div className="container-fluid text-center mt-3 justify-content-center">
        <div className="row align-items-start ">
          <div className="col-7">
            <div>
              <h3 className="fw-bolder">Your New Challenge :</h3>
              <div className="fs-1 text-warning fw-border m-5">
                {this.state.a} x {this.state.b}
              </div>
            </div>
            <form onSubmit={this.handleSubmitResult}>
              <label className="form-label">
                Your alias:
                <input
                  className="form-control m-1"
                  type="text"
                  maxLength="12"
                  name="user"
                  value={this.state.user}
                  onChange={this.handleChange}
                />
              </label>
              <br />
              <label className="form-label">
                Your guess:
                <input
                  className="form-control m-1"
                  type="number"
                  min="0"
                  name="guess"
                  value={this.state.guess}
                  onChange={this.handleChange}
                />
              </label>
              <br />
              <input
                type="submit"
                value="Submit"
                className="btn btn-lg btn-outline-primary"
              />
            </form>
            <h4 className="text-dark fw-bold mt-3">{this.state.message}</h4>
            {this.state.lastAttempts.length > 0 && (
              <LastAttemptsComponent lastAttempts={this.state.lastAttempts} />
            )}
          </div>
          <div className="col-5">
            <LeaderBoardComponent />
          </div>
        </div>
      </div>
    );
  }
}

export default ChallengeComponent;
