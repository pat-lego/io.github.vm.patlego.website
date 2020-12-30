import Nav from '@/components/Nav.vue'
import { shallowMount, createLocalVue, RouterLinkStub  } from '@vue/test-utils'

describe('Nav.vue', () => {
  it('header tabs', () => {
    const wrapper = shallowMount(Nav, {
      stubs: {
        NuxtLink: RouterLinkStub
      }
    })
    expect(wrapper.html().match(new RegExp('header-item', 'g') || []).length).toEqual(3)
  })
})
