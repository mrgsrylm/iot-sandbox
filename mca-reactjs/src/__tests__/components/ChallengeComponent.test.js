import { render, screen } from '@testing-library/react';
import ChallengeComponent from '../../components/ChallengeComponent'

test('renders ChallengeComponent page', () => {
  render(<ChallengeComponent />);
  const titleElement = screen.getByText(/Your new challenge is/i);
  const aliasForm = screen.getByText(/Your alias:/i);
  const guessForm = screen.getByText(/Your guess:/i);
  const buttonSubmit = screen.getByText(/Submit/i);

  expect(titleElement).toBeInTheDocument();
  expect(aliasForm).toBeInTheDocument();
  expect(guessForm).toBeInTheDocument();
  expect(buttonSubmit).toBeInTheDocument();
});
