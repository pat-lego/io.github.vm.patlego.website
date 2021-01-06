<template>
  <div id="app" class="flex flex-col w-full">
    <div>
      <header-component />
    </div>
    <div class="flex component">
      <div
        v-if="data === undefined"
        class="flex justify-center items-center w-full h-52 animate-spin"
      >
        <font-awesome-icon
          class="text-6xl hover:text-blue-300"
          :icon="['fa', 'spinner']"
        />
      </div>
      <div v-else-if="data !== error" class="flex flex-col">
        <div class="w-full sm:w-3/4">
          <div
            class="flex content-center sm:pl-10 pb-5 text-2xl lg:text-3xl xl:text-4xl"
          >
            {{ data.blogTitle }}
          </div>
        </div>
        <div class="flex w-full sm:justify-center sm:content-center">
          <div class="w-11/12 sm:w-3/4 sm:p-20 bg-gray-100">
            <div class="blog break-all" v-html="data.blog"></div>
          </div>
        </div>
        <div class="w-fullsm:w-1/2 sm:pl-10 pt-5 pb-5">
          <div class="flex content-center italic">
            By: {{ data.blogAuthor }}
          </div>
        </div>
      </div>
      <div
        v-else
        class="flex flex-col justify-center items-center align-middle w-full"
      >
        <div>
          <font-awesome-icon
            class="fa-10x hover:text-blue-300"
            :icon="['fa', 'exclamation-triangle']"
          />
        </div>
        <div class="pt-5 italic">{{ data }} loading the blog</div>
      </div>
    </div>
    <div class="flex h-40 pt-10 w-full">
      <footer-component />
    </div>
  </div>
</template>
<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
export default {
  name: "blog-view",
  components: {
    "header-component": Header,
    "footer-component": Footer,
  },
  data: () => {
    return {
      error: "An error occured",
      data: undefined,
      footer: {
        github: "https://github.com/pat-lego",
        twitter: "https://twitter.com/_patlego",
        linkedin: "https://www.linkedin.com/in/patrique-legault/",
        stackoverflow:
          "https://stackoverflow.com/users/8828583/patrique-legault",
      },
    };
  },
  head() {
    return {
      title: "Personalized Blog",
      meta: [
        {
          hid: "description",
          name: "description",
          content: "Blog",
        },
        {
          hid: "og:title",
          name: "og:title",
          content: "Patrique Legault Blog",
        },
        {
          hid: "og:description",
          name: "og:description",
          content: "Enjoy this personalized blog",
        },
        {
          hide: "twitter:title",
          name: "twitter:title",
          content: "Patrique Legault Blog",
        },
        {
          hide: "twitter:description",
          name: "twitter:description",
          content: "Enjoy this personalized blog",
        },
        {
          hid: "keywords",
          name: "keywords",
          content:
            "Web Development, Blog, Blogger, Vue.js, Java, OSGi, Apache Karaf, Technical Architect, Amazon Web Services",
        },
      ],
    };
  },
  /**
   * This fetch invocation is performed on the client, as you can see below the fetchOnServer parameter is set to false.
   * In comparison fetch and asyncData are both used to retrieve data on the server and then merge it into the page template.
   * This is not something that works well when generating static HTML since there is no server rendering the HTML page.
   *
   * If external data is to be fixed for a long period of time then using asyncData
   * is a wise investment.
   *
   * Refer to these options when using asyncData as it needs to know the external service endpoint in order to retrieve the data
   * at build time https://http.nuxtjs.org/options/
   */
  async fetch() {
    if (process.env.NODE_ENV === "development") {
      try {
        this.data = await fetch(
          `http://localhost:8181/cxf/patlegovm/1.0/site/blogs/${this.$route.query.id}`
        ).then((res) => res.json());
      } catch (e) {
        this.data = this.error;
      }
    } else {
      try {
        this.data = await fetch(
          `/cxf/patlegovm/1.0/site/blogs/${this.$route.query.id}`
        ).then((res) => res.json());
      } catch (e) {
        this.data = this.error;
      }
    }
  },
  fetchOnServer: false,
};
</script>
<style scoped>
.blog >>> .prgrph {
  padding: 0.4rem;
}
.blog >>> h1 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> h2 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> h3 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> h4 {
  font-size: revert;
  font-weight: revert;
  margin: revert;
}
.blog >>> ul {
    display: block;
    list-style-type: disc;
    margin: revert;
    padding:revert;
}
</style>
