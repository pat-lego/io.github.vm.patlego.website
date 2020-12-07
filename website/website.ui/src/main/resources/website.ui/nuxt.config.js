export default {
  router: {
    base: '/patlego/'
  },
  head: {
    title: "Patrique Legault",
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      {
        hid: "description",
        name: "description",
        content: "My personal website",
      },
    ]
  },
  target: "static",
  buildModules: ["@nuxtjs/tailwindcss", "@nuxtjs/fontawesome"],
  fontawesome: {
    icons: {
      solid: true,
      brands: true,
    },
  },
  plugins: [{
    src: '~/plugins/hotjar.js',
    mode: 'client'
  }],
  modules: ['@nuxt/http']
};
