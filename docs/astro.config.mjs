import { defineConfig } from 'astro/config';
import starlight from '@astrojs/starlight';

// https://astro.build/config
export default defineConfig({  
	site: 'https://truthchain.dev',
	integrations: [
		starlight({
			title: 'Thruthchain Docs',
			logo: {
				light: './src/assets/logo-light.svg',
				dark: './src/assets/logo-dark.svg',
				alt: 'Truthchain Logo',
				replacesTitle: true,
			},
			social: {
				github: 'https://github.com/Collabwriting/Truthchain',
			},
			sidebar: [
				{
					label: 'Overview',
					items: [
						// Each item here is one entry in the navigation menu.
						{ label: 'Introduction', link: '/overview/introduction/' },
						{ label: 'Concepts', link: '/overview/concepts/'},
						{
							label: 'Architecture',
							items: [
								{ label: 'Overview', link: '/overview/architecture/overview' },
								{ label: 'Data Verifiers', link: '/overview/architecture/verifiers' },
								{ label: 'Truthchain API', link: '/overview/architecture/api' },
								{ label: 'JavaScript SDK', link: '/overview/architecture/javascript-sdk' },
								{ label: 'DKG', link: '/overview/architecture/dkg' },
							],
						},
						{ label: 'Installation (Coming soon)', link: '/overview/installation/'},
					],
				},
				{
					label: 'Reference',
					autogenerate: { directory: 'reference' },
				},
			],
		}),
	],
});
