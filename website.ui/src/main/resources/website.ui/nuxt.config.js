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
        content: "Development without limits",
      },
      {
        hid: "author",
        name: "author",
        content: "Patrique Legault"
      },
      {
        hid: "keywords",
        name: "keywords",
        content: "Web Development, Vue.js, Java, OSGi, Apache Karaf, Technical Architect, Amazon Web Services" 
      },
      // Open Graph Tags
      {
        hid: "og:site_name",
        name: "og:site_name",
        content: "Patrique Legault"
      },
      {
        hid: "og:title",
        name: "og:title",
        content: "Patrique Legault"
      },
      {
        hid: "og:description",
        name: "og:description",
        content: "A place where I can develop and post content."
      },
      {
        hid: "og:image",
        name: "og:image",
        content: "https://i.imgur.com/dSI4zkw.jpeg"
      },
      {
        hid: "og:image:alt",
        name: "og:image:alt",
        content: "Profile Picture"
      },
      {
        hid: "og:url",
        name: "og:url",
        content: "https://www.pat-lego.com/patlego/profile"
      },
      // Twitter Cards
      {
        hide: "twitter:title",
        name: "twitter:title",
        content: "Patrique Legault"
      },
      {
        hide: "twitter:description",
        name: "twitter:description",
        content: "A place where I can develop and post content."
      },
      {
        hid: "twitter:image",
        name: "twitter:image",
        content: "https://i.imgur.com/dSI4zkw.jpeg"
      },
      {
        hid: "twitter:image:alt",
        name: "twitter:image:alt",
        content: "Profile Picture"
      },
      {
        hid: "twitter:card",
        name: "twitter:card",
        content: "summary"
      },
      {
        hid: "twitter:site",
        name: "twitter:site",
        content: "@_patlego"
      }
    ]
  },
  target: "static",
  buildModules: ["@nuxtjs/tailwindcss", "@nuxtjs/fontawesome", "@nuxtjs/axios",],
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
  css: [
    '~/assets/css/roboto.css',
    '~/assets/css/styles.css',
  ],

  axios: {
    baseURL: '/', // Used as fallback if no runtime config is provided
  }
};
