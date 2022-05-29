import Head from 'next/head';
import Login from '../../components/login';

export default function LoginPage() {
	return (
		<div>
			<Head>
				<title>Logout</title>
			</Head>
			<Login />
		</div>
	);
}
