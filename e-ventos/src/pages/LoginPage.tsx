import { LoginForm } from '../components/Auth/LoginForm';
import { useAuth } from '../hooks/useAuth';

export function LoginPage() {
  const { signIn, signUp } = useAuth();

  return (
    <div className="min-h-screen bg-gray-50 flex items-center justify-center px-4">
      <LoginForm onSignIn={signIn} onSignUp={signUp} />
    </div>
  );
}
