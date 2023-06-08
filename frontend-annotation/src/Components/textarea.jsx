/* This example requires Tailwind CSS v2.0+ */
import { StarIcon } from '@heroicons/react/solid'
import {TokenAnnotator, TextAnnotator} from 'react-text-annotate'
import React from 'react'
import Navbar from "./Home";
import { useState,useEffect } from 'react'

import Sidebar from './sidebar'

const reviews = [
  {
    id: 1,
    title: "1.1: From Democritus to the 19th Century- Historical Developments in Chemistry",
    rating: 5,
content:'Chemistry is the study of the material world. What are different materials made of? How is their composition and structure related to their properties? How does one material become transformed into another? These are the sorts of questions that have driven the development of chemistry.People have been using chemistry for a very long time. Medicines were obtained from plants in early societies all over the world. People made dyes for clothing and paints for houses. Metallurgy was practised in India and the Sahel, in Africa, before 1000 BC.The Greek philosopher, Democritus, is often cited as the earliest person to formulate an idea of atoms, although similar ideas were recorded in India around the same time. Democritus thought that all things were made of atoms. Atoms were very small, he thought. They were also indivisible. Although you could cut a piece of wood in half, and cut each of those pieces in half, at some point you would reach the stage at which the wood could not be cut any longer, because you had a slice that was one atom thick.There were an infinite variety of atoms, Democritus thought, making up an infinite variety of materials in the world. The properties of those atoms were directly responsible for the properties of materials. Water was made of water atoms, and water atoms were slippery. Iron was made of iron atoms, and iron atoms were strong and hard.',    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
    value: [],
    tag: 'Chemical',
  },  

  // More reviews...
]

const getHeaders = () => {
  const token = localStorage.getItem("auth");
  return {headers :{    Authorization: `Bearer ${token}`}}
}
const header = getHeaders()
const Text = JSON.stringify(reviews.map((review) => review.content)).slice(2,-2)
let TAG_COLORS = {
  Classe1:'#a6a832',
  Classe2:'#3283a8',
  Classe3:'#ff40df',
}

function classNames(...classes) {
  return classes.filter(Boolean).join(' ')
}

class Annot extends React.Component{
    state = {
        value: [],
        tag: 'Classe1',
      }

      async componentDidMount(){

       const data = await fetch("http://localhost:8080/ScientificClass",header)
        .then(response => response.json())
        // 4. Setting *data* to the API DATA that we received from the response above
        .then(function(json){
          console.log(json)
          return json
        })
        this.setState({data:data})
        console.log("classe",this.state.data)
        this.state.data?.map((classe) => {TAG_COLORS[classe.name] = classe.color})
        console.log("tagakaka",TAG_COLORS)
   
      }

      handleChange = value => {
        this.setState({value})
        console.log(this.state.value)

      }
    
      handleTagChange = e => {
        this.setState({tag: e.target.value})
      }
render(){
  return (
    <><Navbar></Navbar><Sidebar></Sidebar><div className="bg-white">

      <div className="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8 " style={{ marginTop: -90 }}>

        <div className="mt-6 pb-10 border-t border-b border-gray-200 divide-y divide-gray-200 space-y-10">

          {reviews.map((review) => (
            <div key={review.id} className="pt-10 lg:grid lg:grid-cols-12 lg:gap-x-8">
              <div className="lg:col-start-5 lg:col-span-8 xl:col-start-4 xl:col-span-9 xl:grid xl:grid-cols-3 xl:gap-x-8 xl:items-start">


                <div className="mt-4 lg:mt-6 xl:mt-0 xl:col-span-2">

                  <select style={{ marginLeft: -4 }} className="mt-3 space-y-6 text-sm text-black-500" onChange={this.handleTagChange} value={this.state.tag}>
                    <option value="Classe1">Classe1</option>
                    <option value="Classe2">Classe2</option>
                    <option value="Classe3">Classe3</option>

                  </select>
                  <br /><br />
                  <h5 className="text-sm font-medium text-gray-900">{review.title}</h5>

                  <TokenAnnotator
                    className="mt-3 space-y-6 text-sm text-black-500"

                    tokens={Text.split(' ')}
                    value={this.state.value}
                    onChange={this.handleChange}
                    getSpan={span => ({
                      ...span,
                      tag: this.state.tag,
                      color: TAG_COLORS[this.state.tag],
                    })} />
                </div>
              </div>
              <div className="bg-white px-4 py-5 border-b border-gray-200 sm:px-6">
                <div className="-ml-4 -mt-2 flex items-center justify-between flex-wrap sm:flex-nowrap">

                  <div className="ml-4 mt-2 flex-shrink-0" style={{ marginLeft: 1068 }}
                  >
                    <button

                      type="button"
                      className="relative inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    >
                      Save
                    </button>
                    <button
                 
                      style={{ marginLeft: 8 }}

                      type="button"
                      className="relative inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-orange-400 hover:bg-orange-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    >
                      Export
                    </button>

                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div></>
  )
          }
}

export default Annot;